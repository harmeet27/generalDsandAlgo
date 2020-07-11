package com.preparation.companywise.delphix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

class Solution {
    public static void main(String[] args) {

        //read key, state origin and number of records to fetch as command line args
        String key = "MW9S-E7SL-26DU-VV8V";
        String origin = "mont";
        int records = 10;
        String bartApiToCall = "http://api.bart.gov/api/etd.aspx?cmd=etd&orig=%s&key=%s";

        try {
            //Obtain ApiManger to perform the api call
            StringBuffer apiResponse = BartApiCallManager.performBartGetCall(String.format(bartApiToCall, origin, key));
            RootXmlStringParser xmlParser = new RootXmlStringParser();
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(apiResponse.toString())), xmlParser);
            BartRootDataDto bartRootDataDto = xmlParser.getXmlRootData();
            TransportAnalysis analysis = new TransportAnalysis();
            analysis.fetchTrainAnalysis(bartRootDataDto, records);
        } catch (ParserConfigurationException e) {
            System.out.println("Exception in SAX Parser configuration " + e);
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Exception in SAX parsing of the XML records " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception in retriving input stream for xml" + e);
            e.printStackTrace();
        }
    }
}

class TransportAnalysis {

    public void fetchTrainAnalysis(BartRootDataDto root, int records) {

        //1. sort train on the basis of minutes of departure
        List<BartAnalysedDto> analysedData = arrangeTrainOnDepartureTime(root.getStation().getEtd());
        System.out.println("--------------------------------------------------");
        System.out.println(root.getStation().getName() + "    " + root.getTime());
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < records; i++) {
            if (i < analysedData.size()) {
                System.out.println(analysedData.get(i).getMinutes() + " min  " + analysedData.get(i).getDestination());
            }
        }

    }

    private List<BartAnalysedDto> arrangeTrainOnDepartureTime(List<EtdDto> etds) {
        List<BartAnalysedDto> analysedDtos = new LinkedList();
        for (EtdDto etdDto : etds) {
            List<EstimateDto> estimateDtoList = etdDto.getEstimate();
            for (EstimateDto estimate : estimateDtoList) {
                if (!estimate.getMinutes().toLowerCase().equals("leaving")) {
                    BartAnalysedDto bartAnalysedDto = new BartAnalysedDto(estimate.getMinutes(), etdDto.getDestination());
                    analysedDtos.add(bartAnalysedDto);
                }
            }
        }

        Collections.sort(analysedDtos, new BartAnalysedComparator());
        return analysedDtos;
    }

    private class BartAnalysedComparator implements Comparator<BartAnalysedDto> {
        @Override
        public int compare(BartAnalysedDto val1, BartAnalysedDto val2) {
            return Integer.parseInt(val1.getMinutes()) - Integer.parseInt(val2.getMinutes());
        }
    }
}

class BartApiCallManager {
    static StringBuffer performBartGetCall(String url) {
        StringBuffer response = null;
        try {
            response = new StringBuffer();
            URL urlApi = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlApi.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            System.out.println("Exception occured while calling the Bart Api " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception occured while calling the Bart Api " + e);
            e.printStackTrace();
        }
        return response;
    }
}

class RootXmlStringParser extends DefaultHandler {
    String content = null;
    BartRootDataDto bartRootDataDto;
    Station station = null;
    EtdDto etd;
    List<EtdDto> etdList;
    EstimateDto estimateDto;
    List<EstimateDto> estimateList;

    BartRootDataDto getXmlRootData() {
        return bartRootDataDto;
    }

    RootXmlStringParser() {
        estimateList = new LinkedList<>();
        etdList = new LinkedList<>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new String(ch, start, length).trim();
    }

    @Override
    public void startElement(String uri, String localName, String element, Attributes attributes) throws SAXException {
        //to deserialize on the basis of starting tag of xml
        switch (element) {
            case "root":
                bartRootDataDto = new BartRootDataDto();
                break;

            case "station":
                etdList = new LinkedList<>();
                station = new Station();
                break;

            case "etd":
                estimateList = new LinkedList<>();
                etd = new EtdDto();
                break;

            case "estimate":
                estimateDto = new EstimateDto();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        //to deserialize on the basis of ending tag of xml
        switch (qName) {
            case "uri":
                bartRootDataDto.setUri(content);
                break;
            case "date":
                bartRootDataDto.setDate(content);
                break;
            case "time":
                bartRootDataDto.setTime(content);
                break;
            case "station":
                bartRootDataDto.setStation(station);
                break;

            case "name":
                station.setName(content);
                break;
            case "abbr":
                station.setAbbr(content);
                break;
            case "etd":
                etdList.add(etd);
                station.setEtd(etdList);
                break;
            case "destination":
                etd.setDestination(content);
                break;
            case "abbreviation":
                etd.setAbbreviation(content);
                break;
            case "limited":
                etd.setLimited(Integer.parseInt(content));
                break;
            case "estimate":
                estimateList.add(estimateDto);
                etd.setEstimate(estimateList);
                break;
            case "minutes":
                estimateDto.setMinutes(content);
                break;
            case "platform":
                estimateDto.setPlatform(Integer.parseInt(content));
                break;
            case "direction":
                estimateDto.setDirection(content);
                break;
            case "length":
                estimateDto.setLength(Integer.parseInt(content));
                break;
            case "color":
                estimateDto.setColor(content);
                break;
            case "hexcolor":
                estimateDto.setHexColor(content);
                break;
            case "bikeflag":
                estimateDto.setBikeFlag(Integer.parseInt(content));
                break;
            case "delay":
                estimateDto.setDelay(Long.parseLong(content));
                break;
        }
    }
}

class BartRootDataDto {
    private String uri;
    private String date;
    private String time;
    private Station station;

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}

class Station {
    private String name;
    private String abbr;
    private List<EtdDto> etd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public List<EtdDto> getEtd() {
        return etd;
    }

    public void setEtd(List<EtdDto> etd) {
        this.etd = etd;
    }
}

class EtdDto {
    private String abbreviation;
    private int limited;
    private List<EstimateDto> estimate;
    private String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setLimited(int limited) {
        this.limited = limited;
    }

    public List<EstimateDto> getEstimate() {
        return estimate;
    }

    public void setEstimate(List<EstimateDto> estimate) {
        this.estimate = estimate;
    }
}

class EstimateDto {
    private String minutes;
    private int platform;
    private String direction; //take as enum
    private int length;
    private String color;
    private String hexColor;
    private int bikeFlag;
    private long delay;

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public void setBikeFlag(int bikeFlag) {
        this.bikeFlag = bikeFlag;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }
}

class BartAnalysedDto {
    private String minutes;
    private String destination;

    BartAnalysedDto(String minutes, String destination) {
        this.destination = destination;
        this.minutes = minutes;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getDestination() {
        return destination;
    }

}

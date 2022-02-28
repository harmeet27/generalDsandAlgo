package lld.zeta.service.impl;

import lld.zeta.model.User;
import lld.zeta.service.IdentityService;

public class MobileOtpIdentityServiceImpl implements IdentityService<Integer> {

    @Override
    public Integer generation(User user) {
        return null;
    }

    @Override
    public boolean verification(Integer value, User user) {
        return false;
    }
}

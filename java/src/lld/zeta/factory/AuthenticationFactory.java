package lld.zeta.factory;

import lld.zeta.constants.AuthenticationMechanism;
import lld.zeta.model.User;
import lld.zeta.service.IdentityService;

import java.util.Map;

public class AuthenticationFactory {

    private Map<AuthenticationMechanism, IdentityService<Integer>> identityServiceMap;

    public AuthenticationFactory(Map<AuthenticationMechanism, IdentityService<Integer>> identityServiceMap) {
        this.identityServiceMap = identityServiceMap;
    }

    public Integer generate(AuthenticationMechanism authenticationMechanism, User user) {
        return this.identityServiceMap.get(authenticationMechanism).generation(user);
    }

    public boolean verify(AuthenticationMechanism authenticationMechanism, Integer value, User user) {
        return this.identityServiceMap.get(authenticationMechanism).verification(value, user);
    }

}

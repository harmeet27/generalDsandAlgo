package lld.zeta.service;

import lld.zeta.model.User;

public interface IdentityService<K> {

    K generation(User user);

    boolean verification(K value, User user);

}

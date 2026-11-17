package contracts;

import java.util.Optional;
import model.UserSession;
//Return usersession or Optional.empty() when no user is logged in 
public interface SessionProvider {
    Optional<UserSession> getCurrentSession();
}

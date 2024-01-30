package me.prouge.mazebank.service;

import com.google.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.prouge.mazebank.entities.UserEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginService {

    private static final String EMAIL_REGEX =
            "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    @Inject
    private EntityManager entityManager;

    public boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean login(final String email, final String pwd) {
        TypedQuery<UserEntity> typedQuery
                = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:pwd", UserEntity.class);
        typedQuery.setParameter("email", email);
        typedQuery.setParameter("pwd", pwd);

        return typedQuery.getResultList().size() == 1;
    }

    public void register(final String email, final String pwd) {
        entityManager.getTransaction().begin();
        entityManager.persist(new UserEntity(email, pwd));
        entityManager.getTransaction().commit();
    }

}

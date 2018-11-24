package pl.wrzosdev.findscratchwin.models;

import java.util.Date;

public class User {

    private long id;
    private String password;
    private Date last_login;
    private boolean is_superuser;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private boolean is_staff;
    private boolean is_active;
    private Date date_joined;
    private String[] groups;
    private String[] user_permissions;

}

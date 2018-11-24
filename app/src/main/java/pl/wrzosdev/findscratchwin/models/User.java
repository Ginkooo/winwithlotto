package pl.wrzosdev.findscratchwin.models;

import java.util.Collection;
import java.util.Date;

public class User {

    private long id;
    private String password;
    private Date lastLogin;
    private boolean superuser;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean staff;
    private boolean active;
    private Date dateJoined;
    private Collection<String> groups;
    private Collection<String> userPermissions;

}

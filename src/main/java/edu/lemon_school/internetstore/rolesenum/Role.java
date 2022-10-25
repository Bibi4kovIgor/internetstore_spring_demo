package edu.lemon_school.internetstore.rolesenum;

public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    SUPERVISOR("ROLE_SUPERVISOR"),
    INTERN("ROLE_INTERN");

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleName;
    Role(String roleName) {
        this.roleName = roleName;
    }

}

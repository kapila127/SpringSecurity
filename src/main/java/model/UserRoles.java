package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name="User_Roles")
public class UserRoles 
{
@Id
@Column(name="user_role_id")
private int userRoleId;

@Column(name="UserName")
private String userName;

@Column(name="role")
private String role;
}

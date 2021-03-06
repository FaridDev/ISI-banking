package isi.project.banking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Repository
@Entity
@Table(name="CLIENT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

	@Id
	private String pesel;
	private String login;
	private String password;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	private String email;
	@Column(name="NR_TEL")
	private String nrTel;
	private Date birthday;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Account> accounts;
	
	@Override
	public String toString() {
		return "Client [pesel=" + pesel + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", nrTel=" + nrTel + ", birthday=" + birthday + "]";
	}
}

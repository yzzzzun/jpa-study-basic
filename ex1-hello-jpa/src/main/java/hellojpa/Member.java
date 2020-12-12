package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 테이블은 연관관계의 방향성이 없지만 객체는 방향성이 있다.
 * 
 */
@Entity
public class Member extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@OneToOne
	@JoinColumn(name = "locker_id")
	private Locker locker;

	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberProducts = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// 연관관계 편의 메소드가 양쪽에 있으면 문제의 소지가 있음
//	public void changeTeam(Team team) {
//		this.team = team;
//		//연관관계 편의 메소드 
//		team.getMembers().add(this);
//	}

}

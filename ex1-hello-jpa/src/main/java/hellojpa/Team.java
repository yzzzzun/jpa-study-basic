package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue
	@Column(name = "team_id")
	private Long id;

	private String name;

	// Team : Member = 1: N
	// mappedBy=team : 나는team으로 매핑되어있어 -> team 이 연관관계의 주인이야
	// 읽기만 가능 수정, 추가 불가능
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//연관관계 편의 메소드
	public void addMember(Member member) {
		member.setTeam(this);
		this.members.add(member);
	}

}

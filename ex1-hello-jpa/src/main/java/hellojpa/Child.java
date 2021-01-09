package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;

	/**
	 * parent를 반환합니다.
	 * 
	 * @return parent
	 */
	public Parent getParent() {
		return this.parent;
	}

	/**
	 * parent 초기화 합니다.
	 * 
	 * @param parent 초기화 값
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

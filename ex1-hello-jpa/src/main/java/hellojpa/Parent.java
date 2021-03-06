package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Child> childList = new ArrayList<>();

	/**
	 * childList를 반환합니다.
	 * 
	 * @return childList
	 */
	public List<Child> getChildList() {
		return this.childList;
	}

	/**
	 * childList 초기화 합니다.
	 * 
	 * @param childList 초기화 값
	 */
	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}

	public void addChild(Child child) {
		this.childList.add(child);
		child.setParent(this);
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

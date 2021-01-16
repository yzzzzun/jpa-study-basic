package hellojpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * �뀒�씠釉붿� �뿰愿�愿�怨꾩쓽 諛⑺뼢�꽦�씠 �뾾吏�留� 媛앹껜�뒗 諛⑺뼢�꽦�씠 �엳�떎.
 * 
 */
@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Embedded
	private Period workPeriod;

	@Embedded
	private Address homeAddress;

	@ElementCollection
	@CollectionTable(name = "favorite_food", joinColumns = @JoinColumn(name = "member_id"))
	@Column(name = "food_name") // 임베디드 타입 정의한게 아니라서 컬럼명설정
	private Set<String> favoriteFoods = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "member_id")
	private List<AddressEntity> addressHistory = new ArrayList<>();

	/**
	 * favoriteFoods를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return favoriteFoods
	 */
	public Set<String> getFavoriteFoods() {
		return this.favoriteFoods;
	}

	/**
	 * favoriteFoods 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param favoriteFoods 초기화 값
	 */
	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	/**
	 * addressHistory를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return addressHistory
	 */
	public List<AddressEntity> getAddressHistory() {
		return this.addressHistory;
	}

	/**
	 * addressHistory 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param addressHistory 초기화 값
	 */
	public void setAddressHistory(List<AddressEntity> addressHistory) {
		this.addressHistory = addressHistory;
	}

	/**
	 * 
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * id 珥덇린�솕 �빀�땲�떎.
	 * 
	 * @param id 珥덇린�솕 媛�
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * username瑜� 諛섑솚�빀�땲�떎.
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * username 珥덇린�솕 �빀�땲�떎.
	 * 
	 * @param username 珥덇린�솕 媛�
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * workPeriod瑜� 諛섑솚�빀�땲�떎.
	 * 
	 * @return workPeriod
	 */
	public Period getWorkPeriod() {
		return this.workPeriod;
	}

	/**
	 * workPeriod 珥덇린�솕 �빀�땲�떎.
	 * 
	 * @param workPeriod 珥덇린�솕 媛�
	 */
	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	/**
	 * homeAddress瑜� 諛섑솚�빀�땲�떎.
	 * 
	 * @return homeAddress
	 */
	public Address getHomeAddress() {
		return this.homeAddress;
	}

	/**
	 * homeAddress 珥덇린�솕 �빀�땲�떎.
	 * 
	 * @param homeAddress 珥덇린�솕 媛�
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

}

package jpabook.jpashop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Embedded
	private Address address;

	private DeliveryStatus status;

	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;

	/**
	 * id를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * id 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param id 초기화 값
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * address를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return address
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * address 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param address 초기화 값
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * status를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return status
	 */
	public DeliveryStatus getStatus() {
		return this.status;
	}

	/**
	 * status 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param status 초기화 값
	 */
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	/**
	 * order를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return order
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * order 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param order 초기화 값
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

}

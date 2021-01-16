/**
* FileName : AddressEntity.java
* Created  : 2021. 1. 17.
* Author   : youngjun.jin
* Summary  :
* Copyright (C) 2021 yzzzzun. All rights reserved.
*
* 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
* 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
*/
package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author youngjun.jin
 */
@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue
	private Long id;

	private Address address;

	/**
	 * AddressEntity 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 */
	public AddressEntity() {
		super();
	}

	/**
	 * AddressEntity 클래스의 새 인스턴스를 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param address
	 */
	public AddressEntity(String city, String street, String zipcode) {
		this.address = new Address(city, street, zipcode);
	}

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

}

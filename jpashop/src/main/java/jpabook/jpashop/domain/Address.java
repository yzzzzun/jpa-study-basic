/**
* FileName : Address.java
* Created  : 2021. 1. 17.
* Author   : youngjun.jin
* Summary  :
* Copyright (C) 2021 yzzzzun. All rights reserved.
*
* 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
* 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
*/
package jpabook.jpashop.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author youngjun.jin
 */
@Embeddable
public class Address {

	//값 타입의 장점 : 컬럼 공통정의 가능
	@Column(length = 10)
	private String city;
	@Column(length = 20)
	private String street;
	@Column(length = 10)
	private String zipcode;

	public String fullAddress() {
		return "return Full Address";
		//값 타입의 장점 : 비즈니스 로직에 필요한 메서드를 만들 수있음
	}
	
	/**
	 * city를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * street를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return street
	 */
	public String getStreet() {
		return this.street;
	}

	/**
	 * zipcode를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return zipcode
	 */
	public String getZipcode() {
		return this.zipcode;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 * @author youngjun.jin
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getStreet(), getZipcode());
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @author youngjun.jin
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(getCity(), other.getCity()) && Objects.equals(getStreet(), other.getStreet())
				&& Objects.equals(getZipcode(), other.getZipcode());
	}

	
	
	
}

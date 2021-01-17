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
package jpql;

import javax.persistence.Embeddable;

/**
 * @author youngjun.jin
 */
@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;

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

}

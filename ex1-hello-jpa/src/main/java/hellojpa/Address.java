/**
 * FileName : Address.java
 * Created 	: 2021. 1. 12.
 * Author 	: youngjun.jin
 * Summary 	:
 *
 * 이 문서의 모든 저작권 및 지적 재산권은 youngjun.jin에게 있습니다.
 * 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
 */
package hellojpa;

import javax.persistence.Embeddable;

/**
 * @author youngjun.jin
 */
@Embeddable
public class Address {

	// Address
	private String city;
	private String street;
	private String zipcode;

	public Address() {
		super();
	}

	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	/**
	 * city를 반환합니다.
	 * 
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * street를 반환합니다.
	 * 
	 * @return street
	 */
	public String getStreet() {
		return this.street;
	}

	/**
	 * zipcode를 반환합니다.
	 * 
	 * @return zipcode
	 */
	public String getZipcode() {
		return this.zipcode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}

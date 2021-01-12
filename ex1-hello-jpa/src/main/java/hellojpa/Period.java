/**
 * FileName : Period.java
 * Created 	: 2021. 1. 12.
 * Author 	: youngjun.jin
 * Summary 	:
 *
 * 이 문서의 모든 저작권 및 지적 재산권은 youngjun.jin에게 있습니다.
 * 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
 */
package hellojpa;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

/**
 * @author youngjun.jin
 */
@Embeddable
public class Period {

	// Period
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	/**
	 * startDate를 반환합니다.
	 * 
	 * @return startDate
	 */
	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	/**
	 * startDate 초기화 합니다.
	 * 
	 * @param startDate 초기화 값
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * endDate를 반환합니다.
	 * 
	 * @return endDate
	 */
	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	/**
	 * endDate 초기화 합니다.
	 * 
	 * @param endDate 초기화 값
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Period() {
		super();
	}

}

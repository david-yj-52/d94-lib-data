package tsh.d94.lib.data.orm.movement.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class LocationVo {

	@Column(name = "EQP_ID")
	private String eqpId;

	@Column(name = "PORT_ID")
	private String portId;
}

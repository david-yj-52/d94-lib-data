package tsh.d94.lib.data.orm.carrier.carrLotRel;

import org.springframework.stereotype.Repository;

import tsh.d94.lib.core.data.constant.UseStatCd;
import tsh.d94.lib.core.data.orm.common.repo.BaseJpaRepository;

@Repository
public interface MnCarrLotRelRepo extends BaseJpaRepository<MnCarrLotRel, String> {

	MnCarrLotRel findFirstByCarrIdOrderAndUseStatCdOrderByModifiedAt(String carrId, UseStatCd useStatCd);

	MnCarrLotRel findFirstByLotIdOrderAndUseStatCdOrderByModifiedAt(String lotId, UseStatCd useStatCd);
}

package tsh.d94.lib.data.orm.port;

import org.springframework.stereotype.Repository;

import tsh.d94.lib.core.data.orm.common.repo.BaseJpaRepository;

@Repository
public interface MnPortDefRepo extends BaseJpaRepository<MnPortDef, String> {
}

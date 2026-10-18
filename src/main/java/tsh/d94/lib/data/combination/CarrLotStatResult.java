package tsh.d94.lib.data.combination;

import tsh.d94.lib.data.orm.carrier.carrStat.MnCarrStat;
import tsh.d94.lib.data.orm.lot.MnLotStat;

public record CarrLotStatResult(MnCarrStat carrStat, MnLotStat lotStat) {
}

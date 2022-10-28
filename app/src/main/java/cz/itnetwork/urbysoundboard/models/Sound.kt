package cz.itnetwork.urbysoundboard.models

import android.content.Context
import androidx.annotation.RawRes
import cz.itnetwork.urbysoundboard.R

class Sound private constructor(@RawRes val id: Int, val name: String) {
    companion object {
        fun getSounds(context: Context): List<Sound> =
            with(context.resources) {
                listOf(
                    Sound(R.raw.n400_ty_nulo, getString(R.string.n400_ty_nulo)),
                    Sound(R.raw.ale_pod_kapotou_ostuda, getString(R.string.ale_pod_kapotou_ostuda)),
                    Sound(R.raw.ostuda, getString(R.string.ostuda)),
                    Sound(R.raw.kamarade_ja_mam_mclaren_vole, getString(R.string.kamarade_ja_mam_mclaren)),
                    Sound(R.raw.ty_jsi_ostuda_ty_jsi_nula, getString(R.string.ty_jsi_ostuda_ty_jsi_nula)),
                    Sound(R.raw.tak_toto_je_ostuda, getString(R.string.tak_toto_je_ostuda)),
                    Sound(R.raw.nic_moc_kamarade, getString(R.string.nic_moc_kamarade))
                ).sortedBy {
                    it.name
                }
            }


    }
}

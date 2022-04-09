package org.fcitx.fcitx5.android.ui.main.settings.behavior

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.preference.PreferenceFragmentCompat
import org.fcitx.fcitx5.android.R
import org.fcitx.fcitx5.android.data.prefs.AppPrefs
import org.fcitx.fcitx5.android.ui.main.MainViewModel

class BehaviorSettingsFragment : PreferenceFragmentCompat() {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        viewModel.disableToolbarSaveButton()
        val context = preferenceManager.context
        val screen = preferenceManager.createPreferenceScreen(context)
        AppPrefs.getInstance().createUi(screen)
        preferenceScreen = screen
    }

    override fun onResume() {
        super.onResume()
        viewModel.setToolbarTitle(requireContext().getString(R.string.behavior))
    }
}

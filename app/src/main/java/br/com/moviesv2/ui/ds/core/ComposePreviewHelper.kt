package br.com.moviesv2.ui.ds.core

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(device = "id:pixel_6", apiLevel = 34, uiMode = UI_MODE_NIGHT_NO, group = "light")
@Preview(device = "id:pixel_6", apiLevel = 34, uiMode = UI_MODE_NIGHT_YES, group = "dark")
annotation class ScreenPreview

@Preview(uiMode = UI_MODE_NIGHT_NO, group = "light")
@Preview(uiMode = UI_MODE_NIGHT_YES, group = "dark")
annotation class ComponentPreview

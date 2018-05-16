package com.ingbyr.vdm.models

import com.ingbyr.vdm.utils.VDMConfig
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.io.Serializable
import java.time.LocalDateTime

/**
 * No need to save proxy settings in task instance
 */
class DownloadTaskModel(data: DownloadTask) : ViewModel() {
    val checkedProperty = SimpleBooleanProperty(this, "checked", data.checked ?: false)
    val titleProperty = SimpleStringProperty(this, "title", data.title ?: "No title")
    val sizeProperty = SimpleStringProperty(this, "size", data.size ?: "No size")
    val progressProperty = SimpleDoubleProperty(this, "progress", data.progress ?: 0.0)
}

data class DownloadTask(val vdmConfig: VDMConfig, val time: LocalDateTime, val url: String, var formatID: String = "", var checked: Boolean? = null, var title: String? = null, var size: String? = null, var progress: Double? = null) : Serializable, Comparable<DownloadTask> {
    override fun compareTo(other: DownloadTask): Int {
        return time.compareTo(other.time)
    }
}
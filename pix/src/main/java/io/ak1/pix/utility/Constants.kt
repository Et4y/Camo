package io.ak1.pix.utility

import android.os.Build
import android.provider.MediaStore

/**
 * Created By Akshay Sharma on 17,June,2021
 * https://ak1.io
 */
internal const val TAG = "Pix logs"
internal const val sScrollbarAnimDuration = 500
internal val IMAGE_VIDEO_PROJECTION = arrayOf(
    MediaStore.Files.FileColumns._ID,
    MediaStore.Files.FileColumns.PARENT,
    MediaStore.Files.FileColumns.DISPLAY_NAME,
    MediaStore.Files.FileColumns.DATE_ADDED,
    MediaStore.Files.FileColumns.DATE_MODIFIED,
    MediaStore.Files.FileColumns.MEDIA_TYPE,
    MediaStore.Files.FileColumns.MIME_TYPE,
    MediaStore.Files.FileColumns.TITLE
)

internal const val IMAGE_VIDEO_SELECTION = (MediaStore.Files.FileColumns.MEDIA_TYPE + "="
        + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO
        + " OR "
        + MediaStore.Files.FileColumns.MEDIA_TYPE + "="
        + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE)

internal const val VIDEO_SELECTION = (MediaStore.Files.FileColumns.MEDIA_TYPE + "="
        + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO)

internal const val IMAGE_SELECTION = (MediaStore.Files.FileColumns.MEDIA_TYPE + "="
        + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE)

internal val IMAGE_VIDEO_URI = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
    MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL)!!
} else {
    MediaStore.Images.Media.EXTERNAL_CONTENT_URI!!
}

internal const val IMAGE_VIDEO_ORDER_BY = MediaStore.Images.Media.DATE_MODIFIED + " DESC"

var WIDTH = 0
const val ARG_PARAM_PIX = "options"
internal const val ARG_PARAM_PIX_KEY = "param_pix_key"
package io.github.droidkaigi.confsched2019.session.ui.widget

import android.content.Context
import androidx.core.content.ContextCompat
import io.github.droidkaigi.confsched2019.model.AudienceCategory
import io.github.droidkaigi.confsched2019.model.Category
import io.github.droidkaigi.confsched2019.model.Lang
import io.github.droidkaigi.confsched2019.model.LangSupport
import io.github.droidkaigi.confsched2019.model.Room
import io.github.droidkaigi.confsched2019.model.defaultLang
import io.github.droidkaigi.confsched2019.session.R

interface SessionTagAttributes<T> {
    fun getText(tag: T): String
    fun getTextColor(tag: T): Int
    fun getBackgroundColor(tag: T): Int
}

class AudienceCategoryTagAttributes(private val context: Context) :
    SessionTagAttributes<AudienceCategory> {
    override fun getText(tag: AudienceCategory): String {
        return tag.text.getByLang(defaultLang())
    }

    override fun getTextColor(tag: AudienceCategory): Int {
        return ContextCompat.getColor(
            context,
            when (tag) {
                AudienceCategory.BEGINNERS -> R.color.tag_text_green
                AudienceCategory.UNSPECIFIED -> R.color.tag_text_gray
            }
        )
    }

    override fun getBackgroundColor(tag: AudienceCategory): Int {
        return ContextCompat.getColor(
            context,
            when (tag) {
                AudienceCategory.BEGINNERS -> R.color.tag_bg_green
                AudienceCategory.UNSPECIFIED -> R.color.tag_bg_gray
            }
        )
    }
}

class CategoryTagAttributes(private val context: Context) : SessionTagAttributes<Category> {
    override fun getText(tag: Category): String {
        return tag.name.getByLang(defaultLang())
    }

    override fun getTextColor(tag: Category): Int {
        return ContextCompat.getColor(context, R.color.tag_text_gray)
    }

    override fun getBackgroundColor(tag: Category): Int {
        return ContextCompat.getColor(context, R.color.tag_bg_gray)
    }
}

class LangTagAttributes(private val context: Context) : SessionTagAttributes<Lang> {
    override fun getText(tag: Lang): String {
        return tag.text.getByLang(defaultLang())
    }

    override fun getTextColor(tag: Lang): Int {
        return ContextCompat.getColor(
            context,
            when (tag) {
                Lang.EN -> R.color.tag_text_blue
                Lang.JA -> R.color.tag_text_red
            }
        )
    }

    override fun getBackgroundColor(tag: Lang): Int {
        return ContextCompat.getColor(
            context,
            when (tag) {
                Lang.EN -> R.color.tag_bg_blue
                Lang.JA -> R.color.tag_bg_red
            }
        )
    }
}

class LangSupportTagAttributes(private val context: Context) : SessionTagAttributes<LangSupport> {
    override fun getText(tag: LangSupport): String {
        return tag.text.getByLang(defaultLang())
    }

    override fun getTextColor(tag: LangSupport): Int {
        return ContextCompat.getColor(context, R.color.tag_text_gray)
    }

    override fun getBackgroundColor(tag: LangSupport): Int {
        return ContextCompat.getColor(context, R.color.tag_bg_gray)
    }
}

class RoomTagAttributes(private val context: Context) : SessionTagAttributes<Room> {
    override fun getText(tag: Room): String {
        return tag.name
    }

    override fun getTextColor(tag: Room): Int {
        return ContextCompat.getColor(context, R.color.tag_text_gray)
    }

    override fun getBackgroundColor(tag: Room): Int {
        return ContextCompat.getColor(context, R.color.tag_bg_gray)
    }
}

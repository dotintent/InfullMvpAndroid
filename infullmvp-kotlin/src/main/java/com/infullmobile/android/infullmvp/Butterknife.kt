//Copyright 2014 Jake Wharton
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

package com.infullmobile.android.infullmvp

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as SupportFragment

fun <V : View> View.bindView(id: Int)
        : ReadOnlyProperty<View, V> = required(id, viewFinder)

fun <V : View> Activity.bindView(id: Int)
        : ReadOnlyProperty<Activity, V> = required(id, viewFinder)

fun <V : View> Dialog.bindView(id: Int)
        : ReadOnlyProperty<Dialog, V> = required(id, viewFinder)

fun <V : View> Fragment.bindView(id: Int)
        : ReadOnlyProperty<Fragment, V> = required(id, viewFinder)

fun <V : View> ViewHolder.bindView(id: Int)
        : ReadOnlyProperty<ViewHolder, V> = required(id, viewFinder)

fun ViewHolder.bindDimen(id: Int)
        : ReadOnlyProperty<ViewHolder, Int> = requiredDimen(id, dimensionFinder)

fun View.bindString(id: Int)
        : ReadOnlyProperty<View, String> = requiredString(id, stringFinder)

fun ViewHolder.bindString(id: Int)
        : ReadOnlyProperty<ViewHolder, String> = requiredString(id, stringFinder)

fun ViewHolder.bindStringPlural(id: Int, quantity: Int)
        : ReadOnlyProperty<ViewHolder, String> = requiredPluralString(id, quantity, pluralStringFinder)

fun View.bindColor(id: Int)
        : ReadOnlyProperty<View, Int> = requiredColor(id, colorFinder)

fun View.bindDimen(id: Int)
        : ReadOnlyProperty<View, Int> = requiredDimen(id, dimensionFinder)

fun View.bindDrawable(id: Int)
        : ReadOnlyProperty<View, Drawable> = requiredDrawable(id, drawableFinder)

fun ViewHolder.bindDrawable(id: Int)
        : ReadOnlyProperty<ViewHolder, Drawable> = requiredDrawable(id, drawableFinder)

fun ViewHolder.bindColor(id: Int)
        : ReadOnlyProperty<ViewHolder, Int> = requiredColor(id, colorFinder)

fun <V : View> View.bindOptionalView(id: Int)
        : ReadOnlyProperty<View, V?> = optional(id, viewFinder)

fun <V : View> Activity.bindOptionalView(id: Int)
        : ReadOnlyProperty<Activity, V?> = optional(id, viewFinder)

fun <V : View> Dialog.bindOptionalView(id: Int)
        : ReadOnlyProperty<Dialog, V?> = optional(id, viewFinder)

fun <V : View> Fragment.bindOptionalView(id: Int)
        : ReadOnlyProperty<Fragment, V?> = optional(id, viewFinder)

fun <V : View> ViewHolder.bindOptionalView(id: Int)
        : ReadOnlyProperty<ViewHolder, V?> = optional(id, viewFinder)

fun <V : View> View.bindViews(vararg ids: Int)
        : ReadOnlyProperty<View, List<V>> = required(ids, viewFinder)

fun <V : View> Activity.bindViews(vararg ids: Int)
        : ReadOnlyProperty<Activity, List<V>> = required(ids, viewFinder)

fun <V : View> Dialog.bindViews(vararg ids: Int)
        : ReadOnlyProperty<Dialog, List<V>> = required(ids, viewFinder)

fun <V : View> Fragment.bindViews(vararg ids: Int)
        : ReadOnlyProperty<Fragment, List<V>> = required(ids, viewFinder)

fun <V : View> ViewHolder.bindViews(vararg ids: Int)
        : ReadOnlyProperty<ViewHolder, List<V>> = required(ids, viewFinder)

fun <V : View> View.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<View, List<V>> = optional(ids, viewFinder)

fun <V : View> Activity.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Activity, List<V>> = optional(ids, viewFinder)

fun <V : View> Dialog.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Dialog, List<V>> = optional(ids, viewFinder)

fun <V : View> Fragment.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Fragment, List<V>> = optional(ids, viewFinder)

fun <V : View> ViewHolder.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<ViewHolder, List<V>> = optional(ids, viewFinder)


fun View.bindInt(id: Int)
        : ReadOnlyProperty<View, Int> = requiredInt(id, intFinder)

private val View.viewFinder: View.(Int) -> View?
    get() = { findViewById(it) }
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }
private val Dialog.viewFinder: Dialog.(Int) -> View?
    get() = { findViewById(it) }
private val Fragment.viewFinder: Fragment.(Int) -> View?
    get() = { view.findViewById(it) }
private val ViewHolder.viewFinder: ViewHolder.(Int) -> View?
    get() = { itemView.findViewById(it) }
private val View.stringFinder: View.(Int) -> String?
    get() = { resources.getString(it) }
private val View.colorFinder: View.(Int) -> Int?
    get() = { ContextCompat.getColor(context, it) }
private val ViewHolder.stringFinder: ViewHolder.(Int) -> String?
    get() = { itemView.resources.getString(it) }
private val ViewHolder.drawableFinder: ViewHolder.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(itemView.context, it) }
private val ViewHolder.colorFinder: ViewHolder.(Int) -> Int?
    get() = { ContextCompat.getColor(itemView.context, it) }
private val ViewHolder.pluralStringFinder: ViewHolder.(id: Int, quantity: Int) -> String?
    get() = { id, quantity -> itemView.resources.getQuantityString(id, quantity) }
private val View.dimensionFinder: View.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }
private val View.drawableFinder: View.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(context, it) }
private val View.intFinder: View.(Int) -> Int?
    get() = { resources.getInteger(it) }

private val ViewHolder.dimensionFinder: ViewHolder.(Int) -> Int?
    get() = { itemView.context.resources?.getDimensionPixelSize(it) }

fun viewNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("View ID $id for '${desc.name}' not found.")

fun dimenNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("Dimen ID $id for '${desc.name}' not found.")

fun colorNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("Color ID $id for '${desc.name}' not found.")

fun drawableNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("Drawable ID $id for '${desc.name}' not found.")

fun intNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("Int ID $id for '${desc.name}' not found.")

fun stringNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("String ID $id for '${desc.name}' not found.")

@Suppress("UNCHECKED_CAST")
fun <T, V : View> required(id: Int, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> t.finder(id) as V? ?: viewNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
fun <T> requiredDimen(id: Int, finder: T.(Int) -> Int?)
        = Lazy { t: T, desc -> t.finder(id) ?: dimenNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
fun <T> requiredColor(id: Int, finder: T.(Int) -> Int?)
        = Lazy { t: T, desc -> t.finder(id) ?: colorNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
fun <T> requiredDrawable(id: Int, finder: T.(Int) -> Drawable?)
        = Lazy { t: T, desc -> t.finder(id) ?: drawableNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
fun <T> requiredInt(id: Int, finder: T.(Int) -> Int?)
        = Lazy { t: T, desc -> t.finder(id) ?: intNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
fun <T> requiredString(id: Int, finder: T.(Int) -> String?)
        = Lazy { t: T, desc -> t.finder(id) ?: dimenNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
fun <T> requiredPluralString(id: Int, quantity: Int, finder: T.(id: Int, quantity: Int) -> String?)
        = Lazy { t: T, desc -> t.finder(id, quantity) ?: stringNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(id: Int, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> t.finder(id) as V? }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(ids: IntArray, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> ids.map { t.finder(it) as V? ?: viewNotFound(it, desc) } }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(ids: IntArray, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> ids.map { t.finder(it) as V? }.filterNotNull() }

// Like Kotlin's lazy delegate but the initializer gets the target and metadata passed to it
class Lazy<T, V>(private val initializer: (T, KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
    private object EMPTY

    private var value: Any? = EMPTY

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }
}
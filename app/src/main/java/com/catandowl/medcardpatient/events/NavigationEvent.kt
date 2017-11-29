package com.catandowl.medcardpatient.events

import java.util.*
import kotlin.reflect.KClass

/**
 * Created by vladstarikov on 11/28/17.
 */
data class NavigationEvent(val clazz: Class<out Any>)
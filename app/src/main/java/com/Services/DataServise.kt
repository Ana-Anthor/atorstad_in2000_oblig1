package com.Services

import com.Model.Element

object DataServise {

    var elements = mutableListOf(
        Element("Element 1", "This is the description of element 1"),
        Element("Element 2", "This is the description of element 2")
    )

    fun adding(element: Element){ elements.add(element)}
}
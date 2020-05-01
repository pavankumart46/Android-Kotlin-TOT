### How to Use Data Binding Library with Kotlin
#### DataBinding:
Data binding offers flexibility as well as broad compatibility to your code.
we have been using Data Binding Library to bind application logic and layouts. 
It’s a library that allows you to bind the data of your models directly to the xml views in a very flexible way.
Kotlin very much supports Data Binding Library. We can still bind our layouts with the Kotlin class.
If you want to use data binding and Kotlin, here are a few things to keep in mind:
Data binding is a support library, so it can be used with all Android platform versions all the way back to Android 2.1 (API level 7+).
To use data binding, you need Android Plugin for Gradle 1.5.0-alpha1 or higher. You can see here how to update the Android Plugin for Gradle.
Android Studio 3.0 fully supports kotlin
First of all, create an Android Studio project and add a dependency for Kotlin and few changes for your Project level build.gradle
We also need to add the Data Binding dependency and the ones of Kotlin to the build.gradle file of our app.
//Notice that I made the compiler version a variable in the project level build gradle so it can be managed from a single place. That’s all the configuration we need to start using Data Binding with Kotlin.
Now for Kotlin and Data Binding to work together, add a Kotlin Model Class. This model class is going to bind your layout with your Kotlin activity class.
##### activity_main:
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout
   xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   xmlns:tools="http://schemas.android.com/tools">
   <data>
       <variable
           name="nithya"
           type="com.example.databinding.Name" />
   </data>
<LinearLayout
   android:layout_width="match_parent"
   android:orientation="vertical"
   android:layout_height="match_parent"
   tools:context=".MainActivity">

   <EditText
       android:id="@+id/name"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"/>
<TextView
   android:text="@={nithya.names}"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:id="@+id/ts"/>
   <Button
       android:text="submit"
       android:id="@+id/btn"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"/>

</LinearLayout>
</layout>
```
##### MainActivity:
```kotlin
package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var dataBinding:ActivityMainBinding
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       dataBinding.btn.setOnClickListener{
           Anusha()
       }

   }

   private fun Anusha() {
      // TODO("Not yet implemented")
     val n=dataBinding.name.text.toString()
       val d=Name(n)
       dataBinding.nithya=d
       //dataBinding.ts.text=d.names
     //  dataBinding.ts.text=n
   }
}
```

##### Name.kt
```kotlin
data class Name(var names:String = " ")
```

##### Output:

##### Another Example:

##### Using DataBinding:
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <LinearLayout

        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">

        <Button
            android:id="@+id/plus"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:text="+"
            android:textSize="50dp" />

        <TextView
            android:id="@+id/zero"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="8"
            android:gravity="center"
            android:text="0"
            android:textSize="190dp"

            />

        <Button
            android:id="@+id/minus"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:text="-"
            android:textSize="50dp" />

    </LinearLayout>
</layout>
```

##### MainActivity:
```kotlin
package com.example.databinding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
   var count=0
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
      binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
       binding.plus.setOnClickListener{
           count++
           binding.zero.text=count.toString()
       }
       binding.minus.setOnClickListener{
           count--
           binding.zero.text=count.toString()
       }
   }
}
```

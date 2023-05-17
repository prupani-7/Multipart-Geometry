/* Copyright 2022 Esri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.multipartgeometry.multipartgeometrypoint

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.arcgismaps.ApiKey
import com.arcgismaps.ArcGISEnvironment
import com.arcgismaps.geometry.Multipoint
import com.arcgismaps.geometry.Point
import com.arcgismaps.geometry.SpatialReference
import com.arcgismaps.mapping.ArcGISMap
import com.arcgismaps.mapping.BasemapStyle
import com.arcgismaps.mapping.symbology.PictureMarkerSymbol
import com.arcgismaps.mapping.view.Graphic
import com.arcgismaps.mapping.view.GraphicsOverlay
import com.example.multipartgeometry.multipartgeometrypoint.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // set up data binding for the activity
    private val activityMainBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val mapView by lazy {
        activityMainBinding.mapView
    }

    // create the graphic overlay
    private val graphicsOverlay: GraphicsOverlay by lazy { GraphicsOverlay() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // authentication with an API key or named user is
        // required to access basemaps and other location services
        ArcGISEnvironment.apiKey = ApiKey.create(BuildConfig.API_KEY)
        lifecycle.addObserver(mapView)

        // set up the MapView
        mapView.apply {
            // create an ArcGISMap with a streets basemap
            map = ArcGISMap(BasemapStyle.ArcGISStreets)
            // create graphics overlays to show the inputs and results of the spatial operation
            graphicsOverlays.add(graphicsOverlay)
        }

        // create a viewpoint
        val startPoint = Point(-13046205.896, 4036493.110, SpatialReference.webMercator())

        lifecycleScope.launch {
            // set viewpoint of map view to starting point and scale
            mapView.setViewpointCenter(startPoint, 600.0)
        }

        // Create Multipoint geometry using collection of points representing each individual tree
        val multipoint = Multipoint(
            listOf(
                Point(-13046198.211, 4036513.863),
                Point(-13046194.120, 4036524.953),
                Point(-13046188.702, 4036519.410),
                Point(-13046198.404, 4036504.248),
                Point(-13046195.129, 4036496.487),
                Point(-13046188.322, 4036504.358),
                Point(-13046200.104, 4036487.466),
                Point(-13046188.666, 4036490.755),
                Point(-13046190.700, 4036534.807),
                Point(-13046199.247, 4036478.821),
                Point(-13046192.160, 4036481.595),
                Point(-13046192.986, 4036473.646),
                Point(-13046192.986, 4036473.646),
                Point(-13046187.440, 4036467.071),
                Point(-13046195.186, 4036459.944),
                Point(-13046186.834, 4036458.269),
                Point(-13046199.529, 4036531.277)
            ),
            SpatialReference.webMercator()
        )
        lifecycleScope.launch {
            // create a tree symbol
            val treeSymbol = createPinSymbol()
            // creates a graphic with the tree point and symbol
            val treeGraphic =
                Graphic(multipoint, treeSymbol)
            graphicsOverlay.graphics.add(treeGraphic)
        }
    }

    // Create a tree symbol which is a PictureMarkerSymbol
    private suspend fun createPinSymbol(): PictureMarkerSymbol {
        val pinDrawable = ContextCompat.getDrawable(this, R.drawable.tree) as BitmapDrawable
        val pinSymbol = PictureMarkerSymbol.createWithImage(
            pinDrawable as BitmapDrawable
        )
        pinSymbol.load().getOrThrow()
        pinSymbol.width = 60f
        pinSymbol.height = 50f
        return pinSymbol
    }
}



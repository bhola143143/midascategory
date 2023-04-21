package com.example.midascategory.model

data class ResponseData(
    var ar_view_android: String?,
    var ar_view_ios: String?,
    var availability: String?,
    var buy_now: String?,
    var css: String?,
    var eta: String?,
    var id: Int?,
    var image_gallery: List<ImageGallery>,
    var in_stock: Boolean?,
    var is_ar: Boolean?,
    var is_ios_ar: Boolean?,
    var is_special_price: Boolean?,
    var name: String?,
    var price: String?,
    var product_badges: List<ProductBadge?>?,
    var product_data: List<ProductData>,
    var sku: String?,
    var special_price: String?,
    var type_id: String?
)
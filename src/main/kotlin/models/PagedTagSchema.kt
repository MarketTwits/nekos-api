/**
* Nekos API
* An open source anime artworks API.
*
* OpenAPI spec version: v3
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package news.models

import news.models.TagSchema
import kotlinx.serialization.Serializable






import kotlinx.serialization.SerialName


/**
 * 
 * @param items 
 * @param count 
 */
@Serializable
internal data class PagedTagSchema (
    
    @SerialName("items")
    val items: kotlin.collections.List<TagSchema>,
    
    @SerialName("count")
    val count: kotlin.Int

) {

}


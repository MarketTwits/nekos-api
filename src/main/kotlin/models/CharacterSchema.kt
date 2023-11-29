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

import kotlinx.serialization.Serializable






import kotlinx.serialization.SerialName


/**
 * 
 * @param id The character's ID.
 * @param idV2 The character's ID in the v2 API. Format: UUID
 * @param name The character's name.
 * @param aliases Other names by which the character is known.
 * @param description A description of the character.
 * @param ages All the ages the character officially has/has officially had.
 * @param height The the character's height (in cm).
 * @param weight The character's weight (in kg).
 * @param gender The character's gender.
 * @param species The character's species.
 * @param birthday The character's birthday. Format: MM/DD
 * @param nationality The character's nationality.
 * @param occupations All the occupations the character officially has/has officially had.
 * @param mainImageId The character's main image's ID. This image shows the character and can be used, for example, as the character's \"profile picture\".
 */
@Serializable
internal data class CharacterSchema (
    /* The character's ID. */
    
    @SerialName("id")
    val id: kotlin.Int,
    /* The character's ID in the v2 API. Format: UUID */
    
    @SerialName("id_v2")
    val idV2: kotlin.String,
    /* The character's name. */
    
    @SerialName("name")
    val name: kotlin.String,
    /* Other names by which the character is known. */
    
    @SerialName("aliases")
    val aliases: kotlin.collections.List<kotlin.String>,
    /* A description of the character. */
    
    @SerialName("description")
    val description: kotlin.String,
    /* All the ages the character officially has/has officially had. */
    
    @SerialName("ages")
    val ages: kotlin.collections.List<kotlin.Int>,
    /* The the character's height (in cm). */
    
    @SerialName("height")
    val height: kotlin.Int,
    /* The character's weight (in kg). */
    
    @SerialName("weight")
    val weight: kotlin.Int,
    /* The character's gender. */
    
    @SerialName("gender")
    val gender: kotlin.String,
    /* The character's species. */
    
    @SerialName("species")
    val species: kotlin.String,
    /* The character's birthday. Format: MM/DD */
    
    @SerialName("birthday")
    val birthday: kotlin.String,
    /* The character's nationality. */
    
    @SerialName("nationality")
    val nationality: kotlin.String,
    /* All the occupations the character officially has/has officially had. */
    
    @SerialName("occupations")
    val occupations: kotlin.collections.List<kotlin.String>,
    /* The character's main image's ID. This image shows the character and can be used, for example, as the character's \"profile picture\". */
    
    @SerialName("main_image_id")
    val mainImageId: kotlin.Int

) {

}


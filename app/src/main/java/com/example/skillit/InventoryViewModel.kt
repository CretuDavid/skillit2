package com.example.skillit

import androidx.lifecycle.*
import com.example.skillit.data.Item
import com.example.skillit.data.ItemDao
import kotlinx.coroutines.launch



/**
 * View Model to keep a reference to the Inventory repository and an up-to-date list of all items.
 *
 */
class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {

    // Cache all items form the database using LiveData.
    val allItems: LiveData<List<Item>> = itemDao.getItems().asLiveData()

    /**
     * Returns true if stock is available to sell, false otherwise.
     */


    /**
     * Updates an existing Item in the database.
     */
    fun updateItem(
        itemId: Int,
        itemName: String,
        itemLink: String
    ) {
        val updatedItem = getUpdatedItemEntry(itemId, itemName, itemLink)
        updateItem(updatedItem)
    }


    /**
     * Launching a new coroutine to update an item in a non-blocking way
     */
    private fun updateItem(item: Item) {
        viewModelScope.launch {
            itemDao.update(item)
        }
    }

    /**
     * Decreases the stock by one unit and updates the database.
     */

    /**
     * Inserts the new Item into database.
     */
    fun addNewItem(itemName: String, itemLink: String) {
        val newItem = getNewItemEntry(itemName, itemLink)
        insertItem(newItem)
    }

    /**
     * Launching a new coroutine to insert an item in a non-blocking way
     */
    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    /**
     * Launching a new coroutine to delete an item in a non-blocking way
     */
    fun deleteItem(item: Item) {

        viewModelScope.launch {
            itemDao.delete(item)
        }
    }

    /**
     * Retrieve an item from the repository.
     */
    fun retrieveItem(id: Int): LiveData<Item> {
        return itemDao.getItem(id).asLiveData()
    }

    /**
     * Returns true if the EditTexts are not empty
     */
    fun isEntryValid(itemName: String, itemLink: String): Boolean {
        if (itemName.isBlank() || itemLink.isBlank()) {
            return false
        }
        return true
    }

    /**
     * Returns an instance of the [Item] entity class with the item info entered by the user.
     * This will be used to add a new entry to the Inventory database.
     */
    private fun getNewItemEntry(itemName: String, itemLink: String): Item {
        return Item(
            itemName = itemName,
            itemlink = itemLink
        )
    }

    /**
     * Called to update an existing entry in the Inventory database.
     * Returns an instance of the [Item] entity class with the item info updated by the user.
     */
    private fun getUpdatedItemEntry(
        itemId: Int,
        itemName: String,
        itemLink: String,
    ): Item {
        return Item(
            id = itemId,
            itemName = itemName,
            itemlink = itemLink,
        )
    }

}

/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
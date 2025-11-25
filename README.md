# Rick and Morty Character Viewer 🛸

A native Android application built with Kotlin that interacts with the public Rick and Morty API. The app demonstrates the use of Fragments, ListView adapters, background threading for network requests, and image loading.

---

## 📱 Features

- **Welcome Screen:** A user-friendly landing page with navigation options.
- **Live Data Fetching:** Retrieves a list of characters from rickandmortyapi.com.
- **Search Functionality:** Allows users to search for specific characters by name.
- **Detailed View:** Clicking any character opens a detailed profile showing their species, status, and full-size image.
- **Image Loading:** Asynchronous image loading using the Glide library.
- **Navigation:** Custom Fragment navigation with a managed BackStack.

---

## 🛠️ Technical Stack

### **Language**
- Kotlin

### **IDE**
- Android Studio Ladybug (or newer)

### **UI Components**
- Fragments (Home, List, Search, Detail)
- ListView (Legacy list handling)
- BaseAdapter (Custom adapter implementation)
- ConstraintLayout & LinearLayout

### **Networking & Data**
- `java.net.URL` (Raw network calls)
- Gson (JSON Parsing)
- Threading (Background execution for API calls)

### **Libraries**
- Glide — for loading images from URLs
- Gson — for converting JSON API responses into Kotlin objects

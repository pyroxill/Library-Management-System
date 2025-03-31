# Library Management System - Jayden Robertson
A Java console application for managing library inventory, including books, journals, and audio/video materials. The system supports adding, deleting, editing, and searching items, along with financial calculations for total cost and insurance.

## Features
- Add, delete, and edit books, journals, and AV items
- Input validation for all fields (numeric, text, boolean)
- Search by title, type, or ID
- Calculate total cost of all items
- Automatic insurance cost (50% of total, capped at £400)
- Clear menu navigation
- Error handling for invalid inputs

## How to Use
- Add an Item
  - Select item type (Book/Journal/AV)
  - Enter details (title, cost, availability, etc.)

- Delete an Item
  - View all items
  - Enter the ID of the item to delete

- Edit an Item
  - Search for an item by ID
  - Update specific fields or keep existing values

- Search Items
  - Search by title, type, or ID
  - Results display matching items

- Financial Reports
  - Total Cost: Sum of all item values
  - Insurance Cost: 50% of total (max £400)

## Future Improvements
Persistent Storage (XML/Database) to save data between sessions

## Author
- 👨‍💻 Jayden Robertson
- 📧 Email: jaydensouterrobertson@gmail.com
- 🔗 GitHub: pyroxill

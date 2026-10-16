from datetime import datetime, timedelta

class LibraryItem:
    def due_date(self, title):
        return title, datetime.now()

class Book(LibraryItem):
    def due_date(self, title):
        return title, current + timedelta(days=14)

class DVD(LibraryItem):
    def due_date(self, title):
        return title, current + timedelta(days=7)

class Magazine(LibraryItem):
    def due_date(self, title):
        return title, current + timedelta(days=3)

# Assume current date fixed
current = datetime(2023, 10, 26)
n = int(input())
items = {"BOOK": Book(), "DVD": DVD(), "MAGAZINE": Magazine()}
for _ in range(n):
    itype, title = input().split(maxsplit=1)
    title, due = items[itype].due_date(title.strip('"'))
    print(f"{title}: {due.date()}")

# Notes-application

This repository contains the code for a note-taking application that allows users to create and manage notes.


## Features

- Splash Screen: The application starts with a splash screen featuring an animation.
- Home Page: Users can add notes from the menu bar, and the notes are displayed in a recycled list using either ListView or RecyclerView for Android. No database is used for storing notes. In case of screen rotation, the notes are retrieved to ensure data persistence (the app is not prevented from being killed by Android on rotation).
- Deleting Notes: Long-clicking on an item in the list allows users to delete it, with a confirmation alert for additional safety.
- Note Details: Clicking on an item in the list navigates users to a new page that shows the complete text of the note along with its date and time.
- Text-to-Speech: On the note details page, users can listen to the note using text-to-speech synthesis. The speech synthesis stops if the user changes activity or exits the app.

# Demo:

 [![Video Demonstration](https://drive.google.com/uc?export=download&id=1A_fR8jQovUUTR0GgVYhUQ_sia40JAkbG)](https://drive.google.com/file/d/1A_fR8jQovUUTR0GgVYhUQ_sia40JAkbG/view)

## License

This project is licensed under the MIT License.

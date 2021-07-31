# Overview
This exercise is meant to showcase your technical abilities by conducting a code review on a [Pull Request](https://docs.github.com/en/github/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests) (PR).
* You will be given links to the PR, as well as the issue trying to be solved, a day before your scheduled interview so you have context of the change and an opportunity to inspect the code ahead of time.
* You will pair with a Gaggle software engineer to walkthrough the assigned PR together.
* There will be a number of things we are looking for, but this process is not meant to be stressful.

# Application
This application is a Web Service responsible for providing contact information from our contact database.

# Features
| Feature | Description | Endpoint |
| --- | --- | --- |
| Search By Id  | Retrieve a specific contact by referencing it's unique identifier. | /api/contacts/_{id}_ |
| Search By Name  | Retrieve one or more contacts by searching by name (full or partial).  | /api/contacts?name=_{name}_ |

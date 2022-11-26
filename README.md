<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/rezimaulana/ticket-management-system">
    <img src="assets/images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Ticket Management System</h3>

  <p align="center">
    Ticketing application for clients communicates with the developer regarding the software product that has been purchased
    <br />
    <a href="https://github.com/rezimaulana/ticket-management-system"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/rezimaulana/ticket-management-system">View Demo</a>
    ·
    <a href="https://github.com/rezimaulana/ticket-management-system/issues">Report Bug</a>
    ·
    <a href="https://github.com/rezimaulana/ticket-management-system/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

The following is a brief description of the problem and system flow
* Requirements :
  ```sh
  1. User roles consist of Super Admin, PIC and Customer
  2. Super Admin can create master data
  3. The customer has a separate company that is registered by the Super Admin
  4. One PIC can handle several customers and one customer can only be handled by one PIC predetermined by the Super Admin
  5. This ticket system can be used for many products registered by the Super Admin at the same time
  6. Ticket status includes Open, Closed and Re-open
  7. Customers can make tickets (open), close tickets (closed) and reopen tickets (re-open)
  8. Customers have priority tickets (high, medium, low), for high one month a maximum of 3 times and for medium a maximum of 5 times and for low unlimited
  9. Tickets are in the form of forums and can be replied to by Customers or PICs
  10. Can upload attachments in the forum
  11. Attachments can be more than one or none at all
  12. Notifications to PIC emails and customers involved when creating/changing ticket status or replying to forums
  13. Create a report for: Displays a report on ticket information and its status
  ```
* Technology used :
  ```sh
  1.	Java Spring Boot 
  2.	Hibernate (included 4 style profile: native, hql, spring data jpql, spring data native)
  3.	Json Web Token
  4.	Angular
  5.	PostgreSQL
  6.	Jasper Report
  ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Spring][Spring.io]][Spring-url]
* [![Angular][Angular.io]][Angular-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* Java
  ```sh
  Java 11 is recommended
  ```
* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/rezimaulana/ticket-management-system.git
   ```
2. Install NPM packages on /frontend
   ```sh
   npm install
   ```
3. Build using maven on /backend
   ```sh
   mvn clean install
   ```
4. Run jar using java 11 /backend/target/
   ```sh
   java -jar filename.jar
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Still working useful examples of how this project can be used. Additional screenshots, code examples and demos will be provided in this space. 

_Please refer here on the future to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Backend
    - [x] Database
    - [x] Master API
    - [x] Transaction API
- [x] Frontend
    - [x] Page Layout
    - [x] Routing
    - [x] Connect all feature

See the [open issues](https://github.com/rezimaulana/ticket-management-system/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the GPL-3.0 License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Maulana Rezi Rosadi - [@rezimaulana](https://twitter.com/rezimaulana) - rsazrm@gmail.com

Project Link: [https://github.com/rezimaulana/ticket-management-system](https://github.com/rezimaulana/ticket-management-system)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

I've included a few of resources that i find helpful:

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/rezimaulana/ticket-management-system.svg?style=for-the-badge
[contributors-url]: https://github.com/rezimaulana/ticket-management-system/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/rezimaulana/ticket-management-system.svg?style=for-the-badge
[forks-url]: https://github.com/rezimaulana/ticket-management-system/network/members
[stars-shield]: https://img.shields.io/github/stars/rezimaulana/ticket-management-system.svg?style=for-the-badge
[stars-url]: https://github.com/rezimaulana/ticket-management-system/stargazers
[issues-shield]: https://img.shields.io/github/issues/rezimaulana/ticket-management-system.svg?style=for-the-badge
[issues-url]: https://github.com/rezimaulana/ticket-management-system/issues
[license-shield]: https://img.shields.io/github/license/rezimaulana/ticket-management-system.svg?style=for-the-badge
[license-url]: https://github.com/rezimaulana/ticket-management-system/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/rezimaulana
[product-screenshot]: assets/images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
[Spring.io]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/

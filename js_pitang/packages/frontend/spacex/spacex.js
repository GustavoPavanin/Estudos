/* eslint-disable padded-blocks */
/* eslint-disable no-restricted-syntax */
/* eslint-disable no-undef */
/* eslint-disable space-before-function-paren */
/* eslint-disable semi */

async function getLaunches () {

  const response = await fetch('https://api.spacexdata.com/v4/launches')
  const data = await response.json()

  return data.slice(0, 30)
}

function setLaunchesRows (launches) {
  const launchesRow = document.getElementById('launches_row')
  const launchesHeading = document.querySelector('h1')

  launchesHeading.innerText += `(${launches.length})`

  for (const launch of launches) {
    launchesRow.innerHTML += `
    <div class="col-sm-12 col-xs-12 col-md-6 col-lg-4 col-xl-4">
      <div class="card mb-4 justify-content-center">
      <img src="${launch.links.patch.large}" class="card-img-top mt-2" alt="...">
      <div class="card-body ">
          <h5 class="card-title">${launch.name}</h5>
          <p class="card-text">${launch.details}</p>
          <a class="btn btn-primary" href="launch.html?launchId=${launch.id}">Open details</a>
      </div>
      </div>
    </div>
    `
  }
}

async function main () {
  const launches = await getLaunches()

  setLaunchesRows(launches)
}

main()

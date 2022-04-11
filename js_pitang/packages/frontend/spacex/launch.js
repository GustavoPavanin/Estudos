/* eslint-disable no-trailing-spaces */
/* eslint-disable indent */
/* eslint-disable padded-blocks */
/* eslint-disable no-restricted-syntax */
/* eslint-disable no-undef */
/* eslint-disable space-before-function-paren */
/* eslint-disable semi */

async function getLaunch () {
    const searchParams = new URLSearchParams(window.location.search)
    const id = searchParams.get("launchId")
    const response = await fetch(`https://api.spacexdata.com/v4/launches/${id}`)
    const data = await response.json()
  
    return data
  }
  
  function setLaunch (launch) {
    const name = document.getElementById('name')  
    const launchDiv = document.getElementById('launch')

    name.innerHTML += `${launch.name}`

    launchDiv.innerHTML += `
      <div class="col-8 mx-auto">
        <div class="card">
        <img src="${launch.links.patch.large}" class="mt-2 card-img-top img-fluid img-thumbnail mx-auto" style="max-width: 25rem;" alt="Patch: ${launch.name}">
        <div class="card-body">
            <h5 class="card-title">${launch.name}</h5>
            <p class="card-text">${launch.details}</p>
        </div>
        </div>
      </div>
      `
    }
  
  async function main () {
    const launch = await getLaunch()
  
    setLaunch(launch)
  }
  
  main()

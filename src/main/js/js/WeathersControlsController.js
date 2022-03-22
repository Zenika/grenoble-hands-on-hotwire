import { Controller } from '@hotwired/stimulus'

export class WeathersControlsController extends Controller {

  initialize () {
    this.displaySpinner()
  }

  displaySpinner () {
    const template = document.querySelector('#loading-block')
    const clone = document.importNode(template.content, true)
    document.getElementById('city_weather').children[0]?.remove()
    document.getElementById('city_weather').appendChild(clone)
  }

  setModeButtonActive (event) {
    document.querySelectorAll('#mode-controls a.button').forEach(btn => btn.classList.remove('is-info'))
    event.target.classList.add('is-info')
    this.displaySpinner()
  }

  setDegreeButtonActive (event) {
    document.querySelectorAll('#degree-controls a.button').forEach(btn => btn.classList.remove('is-info'))
    event.target.classList.add('is-info')
    this.displaySpinner()
  }

}

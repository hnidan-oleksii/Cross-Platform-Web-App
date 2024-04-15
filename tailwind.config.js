/** @type {import('tailwindcss').Config} */
const defaultTheme= require('tailwindcss/defaultTheme');
module.exports = {
  content: ['./src/main/resources/templates/**/*.html'],
  theme: {
    extend: {
      fontFamily: {
        sans: ['Inter var', ...defaultTheme.fontFamily.sans],
      }
    },
  },
  plugins: [require('@tailwindcss/container-queries'),require('daisyui'),require(
      '@tailwindcss/forms'),require('@tailwindcss/typography')],
}

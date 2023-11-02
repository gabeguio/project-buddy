const path = require('path');
const CopyPlugin = require("copy-webpack-plugin");
const Dotenv = require('dotenv-webpack');

// Get the name of the appropriate environment variable (`.env`) file for this build/run of the app
const dotenvFile = process.env.API_LOCATION ? `.env.${process.env.API_LOCATION}` : '.env';

module.exports = {
  plugins: [
    new CopyPlugin({
      patterns: [
        {
          from: "static_assets", to: "../",
          globOptions: {
            ignore: ["**/.DS_Store"],
          },
        },
      ],
    }),
    new Dotenv({ path: dotenvFile }),
  ],
  optimization: {
    usedExports: true
  },
  entry: {
    Index: path.resolve(__dirname, 'src', 'pages', 'Index.js'),
    project: path.resolve(__dirname, 'src', 'pages', 'project.js'),
    // createTicket: path.resolve(__dirname, 'src', 'pages', 'createTicket.js'),
    // loadProjects: path.resolve(__dirname, 'src', 'pages', 'loadProjects.js'),
    // viewProject: path.resolve(__dirname, 'src', 'pages', 'viewProject.js'),
    // editProject: path.resolve(__dirname, 'src', 'pages', 'editProject.js'),
    // editTicket: path.resolve(__dirname, 'src', 'pages', 'editTicket.js'),
    // viewTickets: path.resolve(__dirname, 'src', 'pages', 'viewTickets.js'),
  },
  output: {
    path: path.resolve(__dirname, 'build', 'assets'),
    filename: '[name].js',
    publicPath: '/assets/'
  },
  devServer: {
    static: {
      directory: path.join(__dirname, 'static_assets'),
    },
    port: 8000,
    client: {
      // overlay shows a full-screen overlay in the browser when there are js compiler errors or warnings
      overlay: true,
    },
  }
}

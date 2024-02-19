# Scenario 3: Manual AWS Deployment for Remote Backend and Local Frontend

In this scenario you will deploy both the backend and the frontend from your computer to AWS.

1. Run the Lambda service (aka the backend):

   - Build the Java code: `sam build`
   - Choose a Cognito Domain matching the pattern `prod-cd-project-buddy-{FULL NAME}` example Cognito Domain: `prod-cd-project-buddy-gabe-guio`
   - Create an S3 bucket: `aws s3 mb s3://prod-b-project-buddy-{FULL NAME}` example Bucket: `prod-b-project-buddy-gabe-guio`
   - Deploy the SAM template:

   ```
   sam deploy --s3-bucket __BUCKET_FROM_ABOVE__ \
   --parameter-overrides S3Bucket=__BUCKET_FROM_ABOVE__ \
   CognitoDomain=__COGNITO_DOMAIN_FROM_ABOVE__ \
   ```

   > **NOTE:** _Yes you have to provide the same S3 bucket name twice._

   **Take note of the "Outputs" produced by the deploy command. You will be using these soon.**

   > **NOTE:** You may find the terminal outputs by visiting the Cloudformation Dashboard > Select "project-buddy-stack" > Outputs

2. Configure the frontend application:
    - CD into the web directory: `cd web`
    - Copy the `sample.env` file to `.env`: `cp sample.env .env`
    - Open the `.env` file in IntelliJ or Visual Studio Code and update the value for these environment variables using the data from the "Ouptuts" of the `sam deploy` in the previous section.
        - `API_BASE_URL`
        - `COGNITO_DOMAIN`
        - `COGNITO_USER_POOL_ID`
        - `COGNITO_USER_POOL_CLIENT_ID`
        - `COGNITO_REDIRECT_SIGNIN`
        - `COGNITO_REDIRECT_SIGNOUT`

   > **NOTE:** The two _redirect_ URLs should probably be set to the URL of your CloudFront distribution - this information should be included in the output of the `sam deploy` command - but you may wish to have different URLs for each. The _signin_ URL is where a user will be redirected after logging in and the _signout_ URL is where a user will be redirected after logging out.

3. Build and deploy your frontend code
    - CD into the web directory: `cd web`
    - `npm run build`

      This will perform a _production build_ of your frontend application.

    - Copy the build artifacts to the S3 bucket from which your CloudFront distribution is configured to pull.

      ```shell
      aws s3 cp \
        build \
        s3://__BUCKET_FROM_ABOVE__/static/ \
        --recursive
      ```
4. Checkout your application.
    - Visit the CloudFront link displayed in the output of `sam deploy` to see your application in action.
# Sean's flavor of eXtreme Programming
A tool to help teams express what is slowing them down

## Scrum style
I will be describing the Scrum style here because that is what I have actually done,
but it is easy enough to adapt to Kanban if desired.
I will also be omitting parts of this process that are identical to Scrum.

## Units of measurement
- Hours
    - Don't take the word "hour" too literally.
      An "hour" in this context is a convenient part of a day.
      If engineers feel they get 40% of their work done before lunch and 60% after,
      they might say there are 2 hours before lunch and 3 hours after,
      or 4 and 6 if they find the extra granularity more convenient to track. 
- Ideal hours
    - An imaginary time unit used for estimating relative effort.
      It corresponds to the most optimistically productive hour that is still actually possible. 
- Actual hours
    - A single part the day is divided into for tracking our time.
      Convenience for time tracking is more important than corresponding to an hour of real time.
      For example, there may be 6 "actual hours" in a work day.

## Estimation
Stories are estimated in terms of ideal hours.
Go with the most optimistic estimate that is still actually possible.
This does not mean resolve ties by going with the lower value.
No fractions allowed.
Estimates are not restricted to particular whole numbers (such as the fibonacci sequence or powers of 2).
When I used this technique, I found the most common number is 4, then 2 and 8, then 1, then 6 and 12.
Valid numbers for estimates are not restricted for 2 reasons.
First, we want to avoid time spent deciding between two large numbers.
More importantly, it has the potential to bias estimates as a whole in one direction or the other,
which matters because we will actually be doing some number crunching later.

## Iteration
Work is allocated to this iteration based on how much we got done last iteration.
A burn down chart is set up.
The team self-organizes to get the iterations work done via a pull system.
We start by identifying the task someone is least qualified to do, and have them claim that task.
They then pair with the person most qualified to bring them up to speed.
Any time work is added to the iteration, an equal amount of estimated work must be dropped.
Any work that has already started is not available to be dropped.

## Daily
Each engineer allocates all of their actual hours for the previous day.
Everyone allocates the same number of actual hours, but not necessarily to project work.
If it is not because of something we want to change, it is ok to record hours not on project work in a generic "other" category.
If we are not able to spend time on project work because of something that would be nice to change, that reason gets its own category.

## End of iteration

### Number crunching
Filter out incomplete stories.
Sum up the total ideal hours.
Sum up the total actual hours.
Divide actual by ideal to get the ratio that can be used to convert from ideal to actual hours.
Use this multiplier on each individual story to see what its estimate would have been in actual hours, we will call this "expected".
The difference between actual and expected is what could potentially be explained, compute this by subtracting expected from actual.

### Analyze
- If the explain amount is very small compared to the total hours actually worked, ignore it.
- If the explain amount is negative, we got this particular story done comparatively faster than expected.
  Briefly talk about why that might be, then move on.
- If the explain amount is large and positive, discuses the reasons for that and categorize the time appropriately.
  Time from the same story can be allocated to different reasons.
  Time from different stories can be allocated to the same reason.
  Not all time has to be categorized to a reason.

### Publish
Create a pie chart showing what percentage of our time is "ideal",
verses how much is expended for various other reasons.
Some of those reasons can be addressed by engineering,
others by parts of the company outside of engineering.
By accurately communicating the cost at a high level,
stakeholders can make informed decisions regarding how much time to focus on project work,
and how much to focus on addressing what is slowing engineers down.

## Example (one week iteration)

### Accepted stories for this iteration
    ╔════════╤═════╗
    ║name    │ideal║
    ╟────────┼─────╢
    ║page    │    4║
    ╟────────┼─────╢
    ║styling │    1║
    ╟────────┼─────╢
    ║database│    8║
    ╟────────┼─────╢
    ║api     │    2║
    ╟────────┼─────╢
    ║bug     │    1║
    ╚════════╧═════╝
### Daily recording of actual hours
    ╔═════════╤══════╤════════╤══════╗
    ║day      │person│task    │actual║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Alice │styling │     3║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Alice │database│     3║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Alice │bug     │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Alice │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Bob   │page    │     7║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Bob   │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Carol │page    │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Carol │styling │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Carol │database│     4║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Dave  │styling │     7║
    ╟─────────┼──────┼────────┼──────╢
    ║   MONDAY│Dave  │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Alice │styling │     3║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Alice │database│     4║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Alice │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Bob   │page    │     4║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Bob   │database│     1║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Bob   │bug     │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Bob   │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Carol │page    │     8║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Dave  │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Dave  │database│     3║
    ╟─────────┼──────┼────────┼──────╢
    ║  TUESDAY│Dave  │api     │     4║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Alice │page    │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Alice │styling │     7║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Bob   │page    │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Bob   │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Bob   │api     │     6║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Carol │page    │     7║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Carol │api     │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Dave  │page    │     4║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Dave  │styling │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Dave  │api     │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║WEDNESDAY│Dave  │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Alice │page    │     6║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Alice │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Alice │database│     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Bob   │page    │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Bob   │styling │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Bob   │database│     4║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Bob   │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Carol │page    │     8║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Dave  │page    │     4║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Dave  │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Dave  │api     │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║ THURSDAY│Dave  │bug     │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Alice │page    │     5║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Alice │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Alice │database│     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Alice │other   │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Bob   │page    │     7║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Bob   │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Carol │page    │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Carol │styling │     3║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Carol │database│     2║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Carol │other   │     2║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Dave  │page    │     5║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Dave  │styling │     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Dave  │database│     1║
    ╟─────────┼──────┼────────┼──────╢
    ║   FRIDAY│Dave  │other   │     1║
    ╚═════════╧══════╧════════╧══════╝
### Totals
    ╔════════════╤════╗
    ║total ideal │  34║
    ╟────────────┼────╢
    ║total actual│ 150║
    ╟────────────┼────╢
    ║multiplier  │4.41║
    ╚════════════╧════╝
### Time report for stories
    ╔════════╤═════╤══════╤════════╤═══════╗
    ║task    │ideal│actual│expected│explain║
    ╟────────┼─────┼──────┼────────┼───────╢
    ║api     │    4│    13│   17.65│  -4.65║
    ╟────────┼─────┼──────┼────────┼───────╢
    ║bug     │   12│     5│   52.94│ -47.94║
    ╟────────┼─────┼──────┼────────┼───────╢
    ║database│    2│    24│    8.82│  15.18║
    ╟────────┼─────┼──────┼────────┼───────╢
    ║page    │    8│    71│   35.29│  35.71║
    ╟────────┼─────┼──────┼────────┼───────╢
    ║styling │    8│    37│   35.29│   1.71║
    ╚════════╧═════╧══════╧════════╧═══════╝
### How we are spending our time
    ╔═════════════════════════════════════╤══════╗
    ║reason                               │actual║
    ╟─────────────────────────────────────┼──────╢
    ║time spent ideally                   │   100║
    ╟─────────────────────────────────────┼──────╢
    ║company internet down                │    20║
    ╟─────────────────────────────────────┼──────╢
    ║reliance on buggy third party library│    30║
    ╚═════════════════════════════════════╧══════╝
